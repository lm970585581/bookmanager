package smn.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import smn.dao.BookDao;
import smn.dao.LendDao;
import smn.dao.StudentDao;
import smn.util.Pager;
import smn.vo.Book;
import smn.vo.Lend;
import smn.vo.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LendAction extends ActionSupport implements ModelDriven<Lend> {
	private int pageNow = 1;
	private int pageSize = 4;
	private Lend lend = new Lend();
	private String message;

	public Lend getModel() {
		// TODO Auto-generated method stub
		return lend;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	LendDao lendDao = new LendDao();

	public String selectAllLend() throws Exception {
		if (lend.getReaderID() == null || lend.getReaderID().equals("")) {
			this.setMessage("请输入借书证号！");
			return SUCCESS;
		} else if (new StudentDao().selectByReaderId(lend.getReaderID()) == null) {
			this.setMessage("不存在该学生!");
			return SUCCESS;
		}

		temp();
		return SUCCESS;
	}

	public void temp() {
		ArrayList list = lendDao.selectLend(lend.getReaderID(),
				this.getPageNow(), this.getPageSize());

		Pager page = new Pager(pageNow, lendDao.selectLendSize(lend
				.getReaderID()));
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		request.put("readerId", lend.getReaderID());
	}

	public String lendBook() throws Exception {
		BookDao bookDao = new BookDao();
		if (lend.getISBN() == null || lend.getISBN().equals("")
				|| bookDao.selectBook(lend.getISBN()) == null
				|| bookDao.selectBook(lend.getISBN()).getSnum() < 1) {
			temp();
			setMessage("ISBN不能为空或者不存在该ISBN的图书或者该ISBN的图书没有库存量！");
			return SUCCESS;
		}else if(lend.getBookId()==null||lend.getBookId().equals("")||lendDao.selectByBookId(lend.getBookId())!=null){
			temp();
			this.setMessage("该图书ID已经存在或图书ID为空！");
			return SUCCESS;
		}
		Lend l=new Lend();
		l.setBookId(lend.getBookId());
		l.setISBN(lend.getISBN());
		l.setReaderID(lend.getReaderID());
		l.setlTime(new Date());
		lendDao.addLend(l);
		Book book=bookDao.selectBook(lend.getISBN());
		book.setSnum(book.getSnum()-1);
		bookDao.updateBook(book);
		StudentDao studentDao=new StudentDao();
		Student stu=studentDao.selectByReaderId(lend.getReaderID());
		stu.setNum(stu.getNum()+1);
		studentDao.updateStudent(stu);
		temp();
		return SUCCESS;
	}
}
