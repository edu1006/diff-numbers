package com.waes.diff.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.waes.diff.request.DiffRequest;

/**
 *
 * Responsible for stored all information about data diff in this project.
 * 
 * Cotains two list: left and right.
 *
 */
public class DiffData {

	private Map<Integer, List<Integer>> left;
	private Map<Integer, List<Integer>> right;

	/**
	 * Constructor of diff Data
	 * 
	 * Inicialize left and right list
	 */
	public DiffData() {
		left = new LinkedHashMap<>();
		right = new LinkedHashMap<>();
	}

	/**
	 * push in left list
	 * 
	 * @param key
	 * @param request
	 * @return Boolean as status of saving data.
	 */
	public synchronized boolean pushLeft(Integer key, DiffRequest request) {
		if (left.containsKey(key)) {
			return this.left.get(key).add(request.getValue());
		}
		List<Integer> values = new LinkedList<Integer>();
		values.add(request.getValue());
		this.left.put(key, values);
		return this.left.containsKey(key);
	}

	/**
	 * push in right list
	 * 
	 * @param value
	 * @param request
	 * @return Boolean as status of saving data.
	 */
	public synchronized boolean pushRight(Integer key, DiffRequest request) {
		if (right.containsKey(key)) {
			return right.get(key).add(request.getValue());
		}
		List<Integer> values = new LinkedList<Integer>();
		values.add(request.getValue());
		right.put(key, values);
		return this.right.containsKey(key);
	}

	/**
	 * 
	 * @return If left list and right list has the same size.
	 */
	public boolean isEqual(Integer id) {
		if (containsIdRightAndLeft(id)) {
			return this.left.get(id).size() == this.right.get(id).size();
		}
		return Boolean.FALSE;
	}

	private boolean containsIdRightAndLeft(Integer id) {
		return this.left.containsKey(id) && this.right.containsKey(id) ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * 
	 * @return bigger list insidade data diff .
	 */
	public List<Integer> getBigger(Integer id) {
		if (containsIdRightAndLeft(id)) {
			if (this.left.get(id).size() < this.right.get(id).size()) {
				return this.right.get(id);
			} else if (!isEqual(id)) {
				return this.left.get(id);
			}
		}
		return Collections.emptyList();

	}

	/**
	 * Check if left list is bigger then right
	 * 
	 * @param id key of list to be checked
	 * @return True is left is bigger.
	 */
	public boolean isLeftBigger(Integer id) {
		if (containsIdRightAndLeft(id)) {
			return this.left.get(id).size() > this.right.get(id).size();
		}
		return this.left.containsKey(id) ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Check if right list is bigger than left
	 * 
	 * @param id Key of list to be checked
	 * @return Tru is right is bigger
	 */
	public boolean isRightBigger(Integer id) {
		if (containsIdRightAndLeft(id)) {
			return this.right.get(id).size() > this.left.get(id).size();
		}
		return this.right.containsKey(id) ? Boolean.TRUE : Boolean.FALSE;

	}

	/**
	 * 
	 * @return a list with unique elemente betwwen left and right list.
	 */
	public List<Integer> getDiffElementsWhenListEqual(Integer id) {
		Set<Integer> diffLeft = new HashSet<Integer>();
		Set<Integer> diffRight = new HashSet<Integer>();
		diffLeft.addAll(this.left.get(id));
		diffLeft.removeAll(this.right.get(id));

		diffRight.addAll(this.right.get(id));
		diffRight.removeAll(this.left.get(id));
		diffLeft.addAll(diffRight);

		return new ArrayList<Integer>(diffLeft);
	}

	/**
	 * 
	 * @param id
	 * @return left list by id
	 */
	public List<Integer> getleftListById(Integer id) {
		return this.left.containsKey(id) ? this.left.get(id) : Collections.emptyList();
	}

	/**
	 * 
	 * @param id
	 * @return right list by id
	 */
	public List<Integer> getRightListById(Integer id) {
		return this.right.containsKey(id) ? this.right.get(id) : Collections.emptyList();

	}

	/**
	 * pull left id from left list
	 * 
	 * @param id
	 * @return True is sucess on delete id
	 */
	public Boolean pullLeftId(Integer id) {
		if (this.left.containsKey(id)) {
			this.left.remove(id);
			return !this.left.containsKey(id);
		}
		return Boolean.FALSE;
	}

	/**
	 * pull right id from right list
	 * 
	 * @param id
	 * @return True is sucess on delete id
	 */
	public Boolean pullRightId(Integer id) {
		if (this.right.containsKey(id)) {
			this.right.remove(id);
			return !this.right.containsKey(id);
		}
		return Boolean.FALSE;
	}

}
