package service;

import dao.OrderDao;
import dao.OverOrderDao;
import dao.PreOrderDao;
import dao.WorkOrderDao;
import model.PreOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 林宏安 on 2017-10-10.
 */
@Service
public class OrderService {

    @Autowired
    private PreOrderDao preOrderDao;//预约中
    @Autowired
    private WorkOrderDao workOrderDao;//已接收
    @Autowired
    private OverOrderDao overOrderDao;//已完成

    /**
     * 新增订单
     */
    public void addOrder(PreOrder preOrder){
        preOrderDao.save(preOrder);
    }

    /**
     * 取消预约中的订单
     */
    public void rejectPreOrder(String id){
        PreOrder preOrder=preOrderDao.selectByUserId(id);
        preOrderDao.delete(preOrder);
    }

    /**
     * 客户取消进行中的订单
     */
    public void rejectWorkOrder(){

    }

    /**
     * 完成订单
     */
    public void endOrder(){

    }

    /**
     * 接收订单
     */
    public void acceptOrder(){

    }
}
