package com.waes.diff.service;

import org.springframework.stereotype.Service;

import com.waes.diff.data.DiffData;
import com.waes.diff.request.DiffRequest;
import com.waes.diff.response.DiffResponse;
import com.waes.diff.util.MessagesResponseEnum;

/**
 * Service of diff project Responsible for send id's for DiffData
 */
@Service
public class DiffService {

	final DiffData data;

	public DiffService() {
		this.data = new DiffData();
	}

	/**
	 * 
	 * push in diff data left
	 * 
	 * @param id
	 * @param request
	 * @return True with was save if sucess
	 */
	public Boolean pushLeft(Integer id, DiffRequest request) {
		return this.data.pushLeft(id, request);
	}

	/**
	 * 
	 * push in diff data right
	 * 
	 * @param id
	 * @param request
	 * @return True with was save if sucess
	 **/
	public Boolean pushRight(Integer id, DiffRequest request) {
		return this.data.pushRight(id, request);
	}

	/**
	 * get diff elements The results shall provide the following info in JSON format
	 * o If equal return that o If not of equal size just return that o If of same
	 * size provide insight in where the diffs are, actual diffs are not needed. §
	 * So mainly offsets + length in the data
	 * 
	 * @param id
	 * 
	 * @return
	 */
	public DiffResponse getDiff(Integer id) {
		DiffResponse diffResponse = new DiffResponse();

		if (this.data.isEqual(id)) {
			diffResponse.setData(this.data.getDiffElementsWhenListEqual(id));
			diffResponse.setMessage(MessagesResponseEnum.IS_EQUAL.getMessage());
		} else {
			diffResponse = getDataListBigger(id);
		}
		return diffResponse;

	}

	/**
	 * Set informations about bigger list in data diff object.
	 * 
	 * @param id
	 * 
	 * @return diff response with data of bigger list in data diff.
	 *
	 */
	private DiffResponse getDataListBigger(Integer id) {
		DiffResponse response = new DiffResponse();
		response.setData(this.data.getBigger(id));
		if (this.data.isLeftBigger(id)) {
			response.setMessage(MessagesResponseEnum.IS_LEFT_BIGGER.getMessage());
			response.setData(this.data.getleftListById(id));
		} else if (this.data.isRightBigger(id)) {
			response.setMessage(MessagesResponseEnum.IS_RIGHT_BIGGER.getMessage());
			response.setData(this.data.getRightListById(id));

		}
		return response;
	}

	/*
	 * pull id from left list on data
	 *
	 */

	public Boolean pullLeftId(Integer id) {
		return this.data.pullLeftId(id);
	}

	public Boolean pullRightId(Integer id) {
		return this.data.pullRightId(id);
	}

}
