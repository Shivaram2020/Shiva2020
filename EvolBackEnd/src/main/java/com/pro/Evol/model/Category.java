package com.pro.Evol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table
	public class Category 
	{
		@Id
		@GeneratedValue
		private int catid;
	@Column(columnDefinition = "varchar(30)")
		private String catname;
	@Column(columnDefinition="varchar(50)")
		private String catdesc;
		public int getCatid() {
			return catid;
		}

		public void setCatid(int catid) {
			this.catid = catid;
		}

		public String getCatname() {
			return catname;
		}

		public void setCatname(String catname) {
			this.catname = catname;
		}

		public String getCatdesc() {
			return catdesc;
		}

		public void setCatdesc(String catdesc) {
			this.catdesc = catdesc;
		}
		
		

	}




