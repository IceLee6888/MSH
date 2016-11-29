package ui.viewcontroller.manager;

import bl.userbl.UserBLFactory;
import blservice.userblservice.UserBLService;
import component.commontextfield.CommonTextField;
import component.rectbutton.RectButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import vo.SalesmanVO;

/**
 * Created by Kray on 2016/11/26.
 */
public class SalesmanManagementDetailEditViewController {

    private SalesmanVO salesmanVO;

    private WorkerManagementViewController workerManagementViewController;

    @FXML
    private Label accountLabel;

    @FXML
    private Label salesmanIDLabel;

    @FXML
    private CommonTextField salesmanNameText;

    @FXML
    private RectButton cancelButton;

    @FXML
    private RectButton saveButton;

    public void setWorkerManagementViewController(WorkerManagementViewController workerManagementViewController) {
        this.workerManagementViewController = workerManagementViewController;
    }

    public void clickBackButton() {
        workerManagementViewController.back();
        workerManagementViewController.back();
        workerManagementViewController.showSalesmanDetail(salesmanVO);
    }

    public void clickSaveButton() {
        UserBLService userBLService = UserBLFactory.getUserBLServiceImpl_Salesman();
        salesmanVO.salesmanName = salesmanNameText.getText();
        userBLService.update(salesmanVO);

        this.clickBackButton();
    }

    public void showSalesmanEdit(SalesmanVO salesmanVO) {
        this.salesmanVO = salesmanVO;

        accountLabel.setText(salesmanVO.account);
        salesmanIDLabel.setText(salesmanVO.salesmanID);
        salesmanNameText.setText(salesmanVO.salesmanName);
    }
}