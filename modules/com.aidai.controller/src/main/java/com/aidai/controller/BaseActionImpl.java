package com.aidai.controller;

import java.util.List;

import com.aidai.service.ServiceException;
import com.aidai.utils.GenericsUtils;

public abstract class  BaseActionImpl<T,F> extends AbstractBaseAction<T, F> {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void initBefore(T o, F example)throws ServiceException {
	}

	@Override
	protected void initFindBefore(T o, F example)throws ServiceException {
	}

	@Override
	protected void initSecondBefore(T o, F example)throws ServiceException {
	}

	@Override
	protected void initAfter(T o, F example,List<T> items)throws ServiceException {
		request.setAttribute("items", items);
		request.setAttribute("actionType", actionType);
		rsmsg = "加载完成!";
		message(rsmsg);
	}

	@Override
	protected void addBefore(T o, F example)throws ServiceException {
	}

	@Override
	protected void addAfter(T o, F example)throws ServiceException {
	}

	@Override
	protected void modifyBefore(T oldModel,T newModel, F example)throws ServiceException {
		//TODO:前端与后端 以差分的形式构造的后端
		GenericsUtils.copyBean(getGenerateParamClass(0), 0, oldModel,newModel);
	}

	@Override
	protected void modifyAfter(T o, F example)throws ServiceException {
		rsmsg = "修改成功！";
	}

	@Override
	protected void updateBefore(T o, F example)throws ServiceException {
	}

	@Override
	protected void updateAfter(T o, F example)throws ServiceException {
	}

	@Override
	protected void delBefore(T o, F example)throws ServiceException {
	}

	@Override
	protected void delAtfer(T o, F example)throws ServiceException {
		rsmsg = "删除成功";
	}

	@Override
	protected void listBefore(T o, F example)throws ServiceException {
	}

	@Override
	protected void listAtfer(T o, F example)throws ServiceException {
		request.setAttribute("page", page);
		rsmsg = "查询成功!";
	}

	@Override
	protected void initFirstAfter(T o, F example)throws ServiceException {
		request.setAttribute("vo", vo);
	}
}
