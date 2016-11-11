package bl.userbl;

import util.LoginState;

/**
 * Created by Kray on 2016/11/11.
 */
public class UserBLFactory {

    private static UserBLServiceImpl userBLService;

    public synchronized static UserBLServiceImpl getUserBLServiceImpl_Client() {
        if (userBLService == null) {
            userBLService = new UserBLServiceImpl(new Client(), LoginState.LOGOUT);
        }
        return userBLService;
    }

    public synchronized static UserBLServiceImpl getUserBLServiceImpl_Staff() {
        if (userBLService == null) {
            userBLService = new UserBLServiceImpl(new Staff(), LoginState.LOGOUT);
        }
        return userBLService;
    }

    public synchronized static UserBLServiceImpl getUserBLServiceImpl_Salesman() {
        if (userBLService == null) {
            userBLService = new UserBLServiceImpl(new Salesman(), LoginState.LOGOUT);
        }
        return userBLService;
    }

}