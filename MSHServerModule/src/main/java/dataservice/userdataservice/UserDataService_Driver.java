package dataservice.userdataservice;

import po.*;
import util.CreditAction;

import util.DateUtil;

/**
 * Created by Kray on 2016/10/13.
 */
public class UserDataService_Driver {

    public void drive(UserDataService userDataService) {

        ClientPO exampleClientPO = new ClientPO("000000007", "老宋", 500, 1, new DateUtil(2015, 10, 10),
                "18795963603", "no_enterprise", "songkuixi", "123456");
        StaffPO exampleStaffPO = new StaffPO("300001", "隔壁老王", "25010001", "admin", "password");
        SalesmanPO exampleSalesmanPO = new SalesmanPO("100001", "隔壁老李", "admin", "password");
        CreditPO exampleCreditPO = new CreditPO("", new DateUtil(2015, 10, 10), 0, 500, CreditAction.INIT_CREDIT, "000000007");

        UserPO userPO;

        userDataService.addClient(exampleClientPO, exampleCreditPO);

        userDataService.addCreditByID("000000007", 500);

        userDataService.addSalesman(exampleSalesmanPO);

        userDataService.addStaff(exampleStaffPO);

        userDataService.searchClientByID("000000007");

        userDataService.searchSalesmanByID("100001");

        userDataService.searchStaffByID("300001");

        userDataService.searchCreditByID("000000007");

        userDataService.updateClient("000000007", exampleClientPO);

        userDataService.updateSalesman("100001", exampleSalesmanPO);

        userDataService.updateStaff("300001", exampleStaffPO);

    }

}

