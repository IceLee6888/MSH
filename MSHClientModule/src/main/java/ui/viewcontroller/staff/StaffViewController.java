package ui.viewcontroller.staff;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.Main;

import java.io.IOException;

/**
 * Created by SilverNarcissus on 2016/11/27.
 */
public class StaffViewController {
    private BorderPane rootPane;

    private HotelInfoViewController hotelInfoViewController;
    private RoomInfoViewController roomInfoViewController;
    private HotelOrderViewController hotelOrderViewController;

    public StaffViewController(BorderPane rootPane) {
        this.rootPane = rootPane;

        try {
            //加载navbar
            FXMLLoader navLoader = new FXMLLoader();
            navLoader.setLocation(Main.class.getResource("../view/staff/StaffNavbar.fxml"));
            Pane navbar = navLoader.load();

            StaffNavbarController staffNavbarController = navLoader.getController();
            staffNavbarController.setStaffViewController(this);

            rootPane.setLeft(navbar);

        } catch (IOException e) {
            e.printStackTrace();
        }

        hotelInfoViewController = new HotelInfoViewController(rootPane);
        roomInfoViewController = new RoomInfoViewController(rootPane);
        hotelOrderViewController = new HotelOrderViewController(rootPane);
    }

    public void showHotelInfoView() {
        hotelInfoViewController.showHotelDetail();
    }

    public void showRoomInfoList() {
        roomInfoViewController.showRoomAllList();
    }

    public void showHotelOrderList() {
        hotelOrderViewController.showHotelOrderList();
    }
}
