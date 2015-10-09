package com.gotop.dict.action;

import com.gotop.crm.util.BaseAction;
import com.gotop.crm.util.MUO;
import com.gotop.dict.model.EosDictEntry;
import com.gotop.dict.model.EosDictType;
import com.gotop.dict.service.IEosDictEntryService;
import com.gotop.util.Struts2Utils;
import com.gotop.util.XmlConvert;
import com.primeton.utils.AjaxParam;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class EosDictEntryAction extends BaseAction {
    /**
     * 通过spring注入的Service对象.
     * @abatorgenerated
     */
    protected IEosDictEntryService eosDictEntryService;
    
    private EosDictType dictType;
    
    private List<EosDictType> dictTypes;
    
    private EosDictEntry dictEntry;
    
    private List<EosDictEntry> dictEntrys;

    /**
     * 通过spring注入Service的set类.
     * @abatorgenerated
     */
    public void setEosDictEntryService(IEosDictEntryService eosDictEntryService) {
        this.eosDictEntryService = eosDictEntryService;
    }

    /**
     * 通过spring注入Service的get类.
     * @abatorgenerated
     */
    public IEosDictEntryService getEosDictEntryService() {
        return this.eosDictEntryService;
    }
    
    public EosDictType getDictType() {
		return dictType;
	}

	public void setDictType(EosDictType dictType) {
		this.dictType = dictType;
	}

	public List<EosDictType> getDictTypes() {
		return dictTypes;
	}

	public void setDictTypes(List<EosDictType> dictTypes) {
		this.dictTypes = dictTypes;
	}

	public EosDictEntry getDictEntry() {
		return dictEntry;
	}

	public void setDictEntry(EosDictEntry dictEntry) {
		this.dictEntry = dictEntry;
	}

	public List<EosDictEntry> getDictEntrys() {
		return dictEntrys;
	}

	public void setDictEntrys(List<EosDictEntry> dictEntrys) {
		this.dictEntrys = dictEntrys;
	}

	public String dictTypeList(){
	   if(dictType == null){
		   dictType = new EosDictType();
	   }
	   
	   dictTypes = eosDictEntryService.dictTypeList(dictType,this.getPage());
	   this.setDictTypes(dictTypes);
	   return "dictList";
   }
	
	public String queryDictEntryBydictTypeId(){
		dictTypes = eosDictEntryService.dictTypeList(dictType,this.getPage());
		dictEntrys = eosDictEntryService.queryDictEntryBydictTypeId(dictEntry);
		this.setDictTypes(dictTypes);
		this.setDictEntrys(dictEntrys);
		return "dictList";
	}
	
	public String toInsert(){
    	this.setDictEntry(dictEntry);
    	return "toInsert";
    }
	
	public String toUpdate(){
    	dictEntry = eosDictEntryService.getDictEntryById(dictEntry);
    	this.setDictEntry(dictEntry);
    	return "toUpdate";
    }
	
	public void insertItem() throws Exception{
    	String info ="success";
    	try {
    		this.eosDictEntryService.insert(dictEntry);
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
    }
	
	public void updateItem() throws Exception{
    	String info ="success";
    	try {
    		this.eosDictEntryService.update(dictEntry);
    	} catch (Exception e) {
			info="fails";
			log.error("[保存设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
    }
	
	public void deleteItem() throws Exception{
    	String info ="success";
    	try {
    		this.eosDictEntryService.delete(dictEntry);
    	} catch (Exception e) {
			info="fails";
			log.error("[删除设备信息失败！]", e);
			throw e;
		}finally{	
		}
		Struts2Utils.renderText(info);
    }
    
}