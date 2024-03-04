
package com.test.santiago.financial.entity.enums;

/**
* Descripción enumeracion para tipo de documento
* @author santiago.montoya@f2x.com.co
* @Date 27/01/2017
* @version
*
*/
public enum EnumAccountType {
	SAVINGS(0, "AHORROS",46),
	CURRENT(1, "CORRIENTE",23);

	private final int id;
	private final String name;
	private final Integer initialNumber;

	private EnumAccountType(int id, String name, Integer initialNumber) {
		this.id = id;
		this.name = name;
		this.initialNumber = initialNumber;
	}
	
	public int getId() {
		
		return id;
	}
	
	public String getName() {
		
		return name;
	}

	public Integer getInitialNumber() {
		return initialNumber;
	}

	public static EnumAccountType findById(Integer idDocumentType) {
		
		EnumAccountType aRet = null;
		
		for (EnumAccountType documentType : EnumAccountType.values()) {
			if (documentType.getId() == idDocumentType) {
				aRet = documentType;
				break;
			}
		}
		
		return aRet;
	}
}
