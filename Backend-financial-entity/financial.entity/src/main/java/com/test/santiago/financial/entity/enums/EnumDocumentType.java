
package com.test.santiago.financial.entity.enums;

/**
* Descripción enumeracion para tipo de documento
* @author santiago.montoya@f2x.com.co
* @Date 27/01/2017
* @version
*
*/
public enum EnumDocumentType {
	NIT(0, "NIT"),
	CC(1, "CC"),
	CE(2, "CE");

	private final int id;
	private final String name;

	private EnumDocumentType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		
		return id;
	}
	
	public String getName() {
		
		return name;
	}
	
	public static EnumDocumentType findById(Integer idDocumentType) {
		
		EnumDocumentType aRet = null;
		
		for (EnumDocumentType documentType : EnumDocumentType.values()) {
			if (documentType.getId() == idDocumentType) {
				aRet = documentType;
				break;
			}
		}
		
		return aRet;
	}
}
