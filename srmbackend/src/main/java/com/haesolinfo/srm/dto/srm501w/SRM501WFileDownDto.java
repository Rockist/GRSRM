package com.haesolinfo.srm.dto.srm501w;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;

@Entity
@Data
@NamedStoredProcedureQuery(
        name = "SRM501WFileDownDto.FILE_DOWNLOAD",
        procedureName = "dbo.FILE_DOWNLOAD",
        resultClasses = SRM501WFileDownDto.class)
public class SRM501WFileDownDto {
    @Id
    private byte[] FILE_IMAGE;
    private String FILE_NAME;
    private String FILE_EXTENSION;
}
