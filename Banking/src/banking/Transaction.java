package banking;
import java.util.*;
import java.io.Serializable;
import java.text.*;

//class for maintaining transaction details
public class Transaction implements Serializable
{
		private Integer id;
		private Date date;
		Transaction(Integer tid,Date tdate)
		{
				id = tid;
				date = tdate;
		}
		public Integer getId()
		{
				return id;
		}
		public Date getDate()
		{
				return date;
		}
}
