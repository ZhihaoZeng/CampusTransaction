package com.example.transaction.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.transaction.pojo.*;
import com.example.transaction.service.CommodityService;
import com.example.transaction.service.NoticeService;
import com.example.transaction.service.ReservationService;
import com.example.transaction.util.code.ReservationCode;
import com.example.transaction.util.responseFromServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName: ReservationController
 * @Author: 曾志昊
 * @Date: 2020/4/26 16:30
 */
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    NoticeService noticeService;
    @Autowired
    CommodityService commodityService;

    /**
     * 创建预约
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/setupReservation")
    public responseFromServer setupReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        Account account = (Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount");
        if (reservation.getCommodityId() == null || reservation.getCount() == null) {
            return responseFromServer.error();
        } else {
            reservation.setAccountId(account.getId());
            reservation.setStateEnum(ReservationCode.WAITING.getCode());
            return reservationService.setUpReservation(reservation);
        }
    }

    /**
     * 取消预约
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/cancelReservation")
    public responseFromServer cancelReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        Account account = (Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount");
        if (reservation.getId() != null)
            return reservationService.cancelReservation(reservation.getId(), account.getId());
        else
            return responseFromServer.error();
    }


    /**
     * 删除预约
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/deleteReservation")
    public responseFromServer deleteReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        if (verifySeller(reservation, request)) {
            /*在验证的时候已经更新reservation信息*/
            return reservationService.deleteReservation(reservation);
        } else {
            return responseFromServer.illegal();
        }
    }


    /**
     * 通过reservationId 验证请求用户是否是对应的卖家
     *
     * @param reservation
     * @param request
     * @return
     */
    public boolean verifySeller(Reservation reservation, HttpServletRequest request) {
        Account account = (Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount");
        if (reservation.getId() == null)
            return false;
        else {
            responseFromServer response = reservationService.getDetailedReservation(reservation.getId());
            if (response.isSuccess()) {
                /*用户身份验证*/
                reservation = (Reservation) response.getData();
                Commodity commodity = reservation.getCommodity();
                if (commodity != null
                        && commodity.getNotice() != null
                        && commodity.getNotice().getAccountId() != null) {
                    if (commodity.getNotice().getAccountId().intValue() != account.getId().intValue())
                        /*此时要操作的用户跟notice的卖家不符合 非法操作*/
                        return false;
                } else {
                    /*查询错误*/
                    return false;
                }
                /*用户验证成功*/
                return true;
            } else {
                return false;
            }
        }

    }

    /**
     * 设置预约成功----减少库存
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/validateReservation")
    public responseFromServer validateReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        if (verifySeller(reservation, request)) {
            /*验证当前操作用户是否是卖家*/
            return reservationService.validateReservation(reservation, ((Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount")).getId());
        } else {
            return responseFromServer.illegal();
        }
    }


    /**
     * 卖家设置预约为完成
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/finishReservation")
    public responseFromServer finishReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        /*验证当前操作用户是否是卖家*/
        if (verifySeller(reservation, request)) {
            return reservationService.finishReservation(reservation.getId());
        } else {
            return responseFromServer.illegal();
        }
    }

    /**
     * 查看当前商品的所有预约
     *
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/getReservationPageForCommodity")
    public responseFromServer getReservationPageForCommodity(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        Commodity commodity = (Commodity) map.get("commodity");
        Integer pageIndex = (Integer) map.get("pageIndex");
        if (commodity == null) return responseFromServer.error();
        pageIndex = pageIndex == null || pageIndex.intValue() <= 0 ? 1 : pageIndex;
        /*用户核对*/
        responseFromServer response = commodityService.getSimpleCommodity(commodity.getId());
        if (!response.isSuccess()) {
            return responseFromServer.error();
        }
        commodity = (Commodity) response.getData();
        Notice notice = (Notice) noticeService.getSimpleNotice(commodity.getNoticeId()).getData();
        if (notice.getAccountId().intValue() == ((Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount")).getId().intValue()) {
            /*验证成功*/
            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("commodity_id", commodity.getId());
            return reservationService.getReservationsPage(queryWrapper, pageIndex);
        } else {
            return responseFromServer.illegal();
        }
    }

    /**
     * 查看我申请的预约
     *
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/getMyReservation")
    public responseFromServer getMyReservation(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        Account account = (Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount");
        Integer pageIndex = (Integer) map.get("pageIndex");
        pageIndex = pageIndex == null || pageIndex.intValue() <= 0 ? 1 : pageIndex;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("account_id", account.getId());
        Boolean isCommodity = (Boolean) map.get("isCommodity");
        if (isCommodity != null) {
            queryWrapper.eq("type", isCommodity);
        }
        return reservationService.getReservationsPage(queryWrapper, pageIndex);
    }


    /**
     * 查看我接收到的预约
     *
     * @param map
     * @param request
     * @return
     */
    @RequestMapping("/getReservationRequest")
    public responseFromServer getReservationRequest(@RequestBody Map<String, Object> map, HttpServletRequest request) {
        Integer pageIndex = (Integer) map.get("pageIndex");
        pageIndex = pageIndex == null || pageIndex.intValue() <= 0 ? 1 : pageIndex;
        return reservationService.getReservationRequest(((Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount")).getId(), pageIndex);
    }

    /**
     * 获取详细的预约内容
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/getDetailedReservation")
    public responseFromServer getDetailedReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        if (verifySeller(reservation, request)) {
            return responseFromServer.success(reservation);
        } else {
            return responseFromServer.error();
        }
    }

    /**
     * 获取简单预约内容
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/getSimpleReservation")
    public responseFromServer getSimpleReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        if (verifySeller(reservation, request)) {
            reservation.setUser(null);
            reservation.setCommodity(null);
            return responseFromServer.success(reservation);
        } else {
            return responseFromServer.error();
        }
    }

    /**
     * 更新预约内容
     *
     * @param reservation
     * @param request
     * @return
     */
    @RequestMapping("/updateReservation")
    public responseFromServer updateBuyerReservation(@RequestBody Reservation reservation, HttpServletRequest request) {
        if (reservation.getStateEnum() != null && reservation.getStateEnum() != ReservationCode.WAITING.getCode()) {
            return responseFromServer.illegal();
        }
        Account account = (Account) request./* todo 修改获取账号方式*/getAttribute("currentAccount");
        Reservation reservation1 = (Reservation) reservationService.getSimpleReservation(reservation.getId()).getData();
        if (reservation1 == null || reservation1.getAccountId() == null) {
            return responseFromServer.error();
        } else if (reservation1.getAccountId().intValue() != account.getId().intValue()) {
            return responseFromServer.illegal();
        } else {
            return reservationService.updateBuyerReservation(reservation);
        }

    }


}
