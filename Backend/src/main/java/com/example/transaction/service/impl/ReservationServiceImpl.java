package com.example.transaction.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.transaction.dao.CommodityDAO;
import com.example.transaction.dao.ReservationDAO;
import com.example.transaction.pojo.Account;
import com.example.transaction.pojo.Commodity;
import com.example.transaction.pojo.Reservation;
import com.example.transaction.service.ReservationService;
import com.example.transaction.util.MyPage;
import com.example.transaction.util.Nums;
import com.example.transaction.util.code.ReservationCode;
import com.example.transaction.util.responseFromServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * @ClassName: ReservationServiceImpl
 * @Description: 预约
 * @Author: 曾志昊
 * @Date: 2020/4/26 16:32
 */
@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService {

    /**
     * 建立预约
     * @param reservation
     * @return
     */
    @Override
    @Transactional
    public responseFromServer setUpReservation(Reservation reservation) {
        if(reservationDAO.insert(reservation)!=1){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseFromServer.error();
        }
        /*TODO 将预约信息添加到notify中*/
        return responseFromServer.success();
    }

    /**
     * 取消预约：state = CANCELED
     * @param reservation
     * @return
     */
    @Override
    @Transactional
    public responseFromServer cancelReservation(Reservation reservation) {
        reservation.setStateEnum(ReservationCode.CANCELLED.getCode());
        if(reservationDAO.updateById(reservation)!=1){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseFromServer.error();
        }
        return responseFromServer.success();
    }

    /**
     * 删除预约信息
     * @param reservation
     * @return
     */
    @Override
    @Transactional
    public responseFromServer deleteReservation(Reservation reservation) {
        if(reservationDAO.deleteById(reservation.getId())!=1){
            /*手动回滚事务*/
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseFromServer.error();
        }else{
            return responseFromServer.success();
        }
    }

    /**
     * 查询预约信息分页
     * @param queryWrapper
     * @param pageIndex
     * @return
     */
    @Override
    public responseFromServer getReservationsPage(QueryWrapper queryWrapper,Integer pageIndex) {
        Page<Reservation> page = new Page<>(pageIndex, Nums.pageSize);
        IPage<Reservation> reservationPage = reservationDAO.selectPage(page,queryWrapper);
        MyPage myPage = new MyPage(reservationPage);
        return responseFromServer.success(myPage);
    }

    /**
     * 更新预约
     * @param reservation
     * @return
     */
    @Override
    @Transactional
    public responseFromServer updateReservation(Reservation reservation) {
        if(reservationDAO.updateById(reservation)!=1){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  responseFromServer.error();
        }
        return responseFromServer.success();
    }


    /**
     * 设置预约成功
     * @param reservationId
     * @param account
     * @return
     */
    @Override
    @Transactional
    public responseFromServer validateReservation(Integer reservationId, Account account) {
        /*TODO*/
        /*获取reservation 检查id和用户id*/
        Reservation reservation = reservationDAO.selectWithDetailedCommodityById(reservationId);
        Commodity commodity = reservation.getCommodity();
        if(commodity !=null
                &&commodity.getNotice()!=null
                &&commodity.getNotice().getAccountId()!=null){
            if(commodity.getNotice().getAccountId().intValue() != account.getId().intValue())
                /*此时要操作的用户跟notice的卖家不符合 非法操作*/
                return responseFromServer.illegal();
        }else{
            /*查询错误*/
            return responseFromServer.error("查询错误");
        }
        /*用户验证成功*/

        /*验证reservation状态是否是等待状态*/
        if(reservation.getStateEnum()!=ReservationCode.WAITING.getCode()){
            return responseFromServer.error("预约状态错误");
        }
        /*验证状态成功*/

        /*验证commodity库存*/
        if(commodity.getCount()<reservation.getCount()){
            /*库存不足*/
            return responseFromServer.error("库存不足");
        }
        /*库存充足*/

        /*修改reservation状态*/
        reservation.setStateEnum(ReservationCode.VALIDATE.getCode());
        if(reservationDAO.updateById(reservation)!=1){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseFromServer.error("修改预约状态错误");
        }
        Commodity newCommodity = new Commodity();
        newCommodity.setCount(commodity.getCount()-reservation.getCount());
        newCommodity.setId(commodity.getId());
        if(commodityDAO.updateById(newCommodity)!=1){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return responseFromServer.error("修改商品库存出错");
        }
        return responseFromServer.success();
    }



    ReservationDAO reservationDAO;
    CommodityDAO commodityDAO;
    @Autowired
    public ReservationServiceImpl(ReservationDAO reservationDAO,CommodityDAO commodityDAO){
        this.reservationDAO = reservationDAO;
        this.commodityDAO = commodityDAO;
    }


}
