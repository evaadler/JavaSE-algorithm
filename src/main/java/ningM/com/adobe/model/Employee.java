package ningM.com.adobe.model;

import org.joda.time.DateTime;


/**
 * Employee Model
 * 
 * @author ningm
 *
 */
public class Employee implements Comparable<Employee>{



	String _id;
	String email;
	String firstName;
	String lastName;
	String address;
	String entryDate;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj){
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)){
			return false;
		}
		Employee e = (Employee)obj;

		if (this._id.equals(e._id) || this.email.equals(e.email)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null)?0:_id.hashCode());
		result = prime * result + ((email == null)?0:email.hashCode());
		return result;
	}

	@Override
	public int compareTo(Employee e) {
		return Long.compare(new DateTime(this.getEntryDate()).getMillis(), new DateTime(e.getEntryDate()).getMillis());
	}

	@Override
	public String toString() {
		return "Employee [_id=" + _id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", entryDate=" + entryDate + "]";
	}


}