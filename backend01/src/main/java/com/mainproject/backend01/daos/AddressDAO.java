package com.mainproject.backend01.daos;

import com.mainproject.backend01.models.Address;

public interface AddressDAO {

	public void insertAddress(Address address);
	public Address getAddressById(int addressId);
	public void updateAddress(Address address);
	public void deleteAddress(int addressId);
}
