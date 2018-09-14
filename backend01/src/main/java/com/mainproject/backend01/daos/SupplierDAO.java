package com.mainproject.backend01.daos;

import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Supplier;

import java.util.*;

public interface SupplierDAO {

	public boolean addSupplier(Supplier supp);
	public boolean updateSupplier(Supplier supp);
	public void deleteSupplier(int supplierId);
	public List<Supplier> supplier();
	public Supplier getSupplier(int supplierId);
}
