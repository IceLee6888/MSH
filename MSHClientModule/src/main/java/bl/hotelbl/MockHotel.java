package bl.hotelbl;

import util.HotelNotFoundException;
import util.InfoInvalidException;
import util.Place;
import util.ResultMessage;
import vo.AssessmentVO;
import vo.FilterFlagsVO;
import vo.Hotel_DetailVO;

import java.util.ArrayList;

/**
 * Created by Sorumi on 16/10/30.
 */
public class MockHotel extends Hotel {
    /**
     * 通过指定的筛选条件筛选酒店(mock)
     * @param flags
     * @return 符合条件的酒店VO列表
     */
    @Override
    public ArrayList<Hotel_DetailVO> searchHotel(FilterFlagsVO flags) {
        System.out.println("Search hotel Success!");
        Hotel_DetailVO hvo=new Hotel_DetailVO("000000", "汉庭", "南京", Place.XINJIEKOU, 5,"特别好", "设施齐全按",new AssessmentVO(5,5,5,5,"GOOD!!!"));
        ArrayList<Hotel_DetailVO> hotel_detailVOs =new ArrayList<Hotel_DetailVO>();
        hotel_detailVOs.add(hvo);
        return hotel_detailVOs;
    }

    /**
     * 通过酒店ID查找酒店(mock)
     * @param hotelID
     * @return 符合ID的酒店VO
     * @throws HotelNotFoundException
     */
    @Override
    public Hotel_DetailVO getHotel(String hotelID) throws HotelNotFoundException {
        if (hotelID.equals("000000")) {
            System.out.println("Get hotel Success!");
            return new Hotel_DetailVO("000000", "汉庭", "南京", Place.XINJIEKOU, 5, "特别好", "设施齐全按",new AssessmentVO(5,5,5,5,"GOOD!!!"));
        }
        else {
            throw new HotelNotFoundException();
        }
    }

    /**
     * 修改指定酒店信息(mock)
     * @param hvo
     * @return 修改成功与否
     * @throws InfoInvalidException
     */
    @Override
    public ResultMessage updateHotelInfo(Hotel_DetailVO hvo) throws InfoInvalidException {
        if (hvo.ID.equals("000000")){
            System.out.println("Update hotel Success!");
            return ResultMessage.SUCCESS;
        }
        return  ResultMessage.NOT_EXIST;
    }

    /**
     * 添加酒店信息(mock)
     * @param hvo
     * @return 添加成功与否
     * @throws InfoInvalidException
     */
    @Override
    public ResultMessage addHotel(Hotel_DetailVO hvo) throws InfoInvalidException {
        if (hvo.ID.equals("000000")) {
            System.out.println("Add hotel Success!");
            return ResultMessage.SUCCESS;
        }
        return  ResultMessage.EXIST;
    }

    /**
     * 删除酒店信息(mock)
     * @param hotelID
     * @return 删除成功与否
     * @throws HotelNotFoundException
     */
    @Override
    public ResultMessage deleteHotel(String hotelID) throws HotelNotFoundException {
        if (hotelID.equals("000000")) {
            System.out.println("Delete Success!");
            return ResultMessage.SUCCESS;
        }
        return  ResultMessage.NOT_EXIST;
    }
}