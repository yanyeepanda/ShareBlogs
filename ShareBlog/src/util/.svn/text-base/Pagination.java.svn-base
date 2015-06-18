package util;

import java.util.ArrayList;
import java.util.List;

public  class Pagination {
	public List<Object> list=null;
	private int recordCount=0;//总记录数
	private int pageSize=0;//每页的记录数
	private int maxPage=0;//最大页数
	
	//初始化分页信息
	public List getInitPage(List list,int page,int pageSize)
	{
		List<Object> newList=new ArrayList<Object>();
		this.list=list;
		recordCount=list.size();
		this.pageSize=pageSize;
		this.maxPage=getMaxPage();
		try{
			for(int i=(page-1)*pageSize;i<=page*pageSize-1;i++){
				try{
					if(i>=recordCount){break;}
				}catch(Exception e){
					e.printStackTrace();
				}
				newList.add((Object)list.get(i));
			}	
			}catch(Exception e){
				e.printStackTrace();
			}
			return newList;		
	}
	
	//获取指定页的数据
	public List<Object> getAppointPage(int Page){
		List<Object> newList=new ArrayList<Object>();
		try{
			for(int i=(Page-1)*pageSize;i<=Page*pageSize-1;i++){
				try{
					if(i>=recordCount){break;}
				}catch(Exception e){}
				newList.add((Object)list.get(i));
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return newList;
	}
	//获取最大记录数
	public int getMaxPage(){
		int maxPage=(recordCount%pageSize==0)?(recordCount/pageSize):(recordCount/pageSize+1);
		return maxPage;
	}
	
	public void setRecordSize(int RecordSize)
	{
		this.recordCount=RecordSize;
	}
	
	//获取总记录数
	public int getRecordSize(){
		return recordCount;
	}
	
	//获取当前页数
	public int getPage(String str){
		if(str==null){
			str="0";
		}
		int Page=Integer.parseInt(str);
		if(Page<1){
			Page=1;
		}else{
			if(((Page-1)*pageSize+1)>recordCount){
				Page=maxPage;
			}
		}
		return Page;
	}
	
	public String printCtrlByURL(int Page,String url){
		String strHtml="<table width='600'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
		try{
		if(Page>1){
			strHtml=strHtml+"<a href='"+url+"?Page=1'>第一页</a>　";
			strHtml=strHtml+"&nbsp;&nbsp;<a href='"+url+"?Page="+(Page-1)+"'>上一页</a>";
		}
		if(Page<maxPage){
			strHtml=strHtml+"&nbsp;&nbsp;<a href='"+url+"?Page="+(Page+1)+"'>下一页</a>&nbsp;&nbsp;　<a href='"+url+"?Page="+maxPage+"'>最后一页&nbsp;</a>";
		}
		strHtml=strHtml+"</td> </tr>	</table>";
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return strHtml;
	}
	
	public String printCtrl(int Page,String id){
		id="&id="+id;
		String strHtml="<table width='370'  border='0' cellspacing='0' cellpadding='0'><tr> <td height='24' align='right'>当前页数：["+Page+"/"+maxPage+"]&nbsp;&nbsp;";
		try{
		if(Page>1){
			strHtml=strHtml+"<a href='?Page=1"+id+"'>第一页</a>　";
			strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page-1)+id+"'>上一页</a>";
		}
		if(Page<maxPage){
			strHtml=strHtml+"&nbsp;&nbsp;<a href='?Page="+(Page+1)+id+"'>下一页</a>&nbsp;&nbsp;　<a href='?Page="+maxPage+id+"'>最后一页&nbsp;</a>";
		}
		strHtml=strHtml+"</td> </tr>	</table>";
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return strHtml;
	}
}
