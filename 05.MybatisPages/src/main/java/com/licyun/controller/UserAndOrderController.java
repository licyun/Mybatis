package com.licyun.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.licyun.entity.Order;
import com.licyun.entity.User;
import com.licyun.entity.UserMapper;
import com.licyun.util.Page;

@Controller
@RequestMapping("/user")
public class UserAndOrderController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/orderpages")
    public ModelAndView pageList(HttpServletRequest request, HttpServletResponse response) {
        // 当前页数，等价于从前台通过get方式传过来的page
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

        // 每一页显示多少条
        int pageSize = 3;

        // 防止点击上一页currentPage = 0的情况，保证currentPage最小等于1
        if (currentPage <= 0) {
            currentPage = 1;
        }

        // 从第几条开始
        int currentResult = (currentPage - 1) * pageSize;

        // 封装数据到Page类中
        Page page = new Page();
        page.setShowCount(pageSize);
        page.setCurrentResult(currentResult);

        // 通过userid的查询对应的用户和订单数
        int userid = 1;

        //查询从currentResult条开始，共查pageSize条记录封装到List中
        List<Order> orders = userMapper.getOrderListPage(page, userid);

        User user = userMapper.getUserById(userid);

        // 订单总数
        int totalCount = userMapper.getUserOrders(userid).size();


        //计算最后一页的页码
        int lastPage = totalCount % pageSize == 0 ? (totalCount % pageSize) + (totalCount / pageSize)
                : (1 + totalCount / pageSize);

        //确保currentPage比lastPage小，防止点击下一页大于lastPage，导致没有显示数据
        if (currentPage >= lastPage) {
            currentPage = lastPage - 1;
        }

        // ModelAndView这个类为springmvc特有，然后 制定视图，也就是/WEB-INF/jsp/pagelist.jsp
        ModelAndView mav = new ModelAndView("pagelist");
        mav.addObject("currentPage", currentPage);// 把当前页面参数传递到前台
        mav.addObject("orders", orders);// 把查出来的订单数据传递到前台
        mav.addObject("user", user);// 把用户数据传递到前台
        return mav;
    }

}
