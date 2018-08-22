package com.reviewtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.reviewtool.service.AccountService;
import com.reviewtool.entity.Account;

import java.util.List;

/**
* @Author wuyongqiang
* @ClassName AccountController
* @Date 10:39 2018/8/16
* @Version 1.0
**/

//@RestController
@Controller
    @RequestMapping("/account")
    public class AccountController {

        @Autowired
        private AccountService accountService;


        @RequestMapping(value = "/list", method = RequestMethod.GET)
        @ResponseBody
        public String getAccounts(Model model) {
            List<Account> list =accountService.findAccountList();
            model.addAttribute("list",list);
            return "page/list";
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        @ResponseBody
        public Account getAccountById(@PathVariable("id") int id) {
            return accountService.findAccount(id);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        @ResponseBody
        public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                    @RequestParam(value = "money", required = true) double money) {
            int t= accountService.update(name,money,id);
            if(t==1) {
                return "success";
            }else {
                return "fail";
            }

        }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public String delete(@PathVariable(value = "id")int id) {
            int t= accountService.delete(id);
            if(t==1) {
                return "success";
            }else {
                return "fail";
            }

        }

        @RequestMapping(value = "/add",method = RequestMethod.POST)
        @ResponseBody
        public String postAccount(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "money") double money) {

            int t= accountService.add(name,money);
            if(t==1) {
                return "success";
            }else {
                return "fail";
            }

        }


    }
