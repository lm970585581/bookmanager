package smn.util;

public class Pager {
	private int pageNow;
	private int pageSize=4;
	private int totalPage;//���ж���ҳ
	private int totalSize;//��¼��
	private boolean hasFirst;//�Ƿ�����ҳ
	private boolean hasPre;//�Ƿ���ǰһҳ
	private boolean hasNext;//�Ƿ�����һҳ
	private boolean hasLast;//�Ƿ���ĩҳ
	public Pager(int pageNow,int totalSize){
		this.pageNow=pageNow;
		this.totalSize=totalSize;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		//ҳ���㷨
		totalPage=getTotalSize()/getPageSize();
		if(totalSize%pageSize!=0){
			totalPage++;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	public boolean isHasFirst() {
		//�����ǰҳ��Ϊ��һҳ��û����ҳ
		if(pageNow==1){
			return false;
		}else{
			return true;
		}
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	public boolean isHasPre() {
		//�������ҳ����ǰһҳ
		if(this.isHasFirst()){
			return true;
		}else{
			return false;
		}
	}
	public void setHasPre(boolean hasPre) {
		this.hasPre = hasPre;
	}
	public boolean isHasNext() {
		//�����βҳ������һҳ
		if(this.isHasLast()){
			return true;
		}else{
			return false;
		}
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	public boolean isHasLast() {
		//����������һҳ����βҳ
		if(pageNow==this.getTotalPage()){
			return false;
		}else{
			return true;
		}
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	
	
}
