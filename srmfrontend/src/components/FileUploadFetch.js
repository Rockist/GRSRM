
async function FileUploadFetch(host, path, file, itemCd, custCd, fileNo, startDate) {
    const url = `http://${host}/${path}`;
    const form = new FormData();
    form.append('file', file);
    form.append('itemCd', itemCd);
    form.append('custCd', custCd);
    form.append('fileNo', fileNo);
    form.append('startDate', startDate);
    
    const options = { // spring boot 에서 자동으로 multipart 를 붙여주기때문에 없어도됨. 
      method: 'POST',
      body: form,
    };
    const res = await fetch(url, options);
    const data = await res.json();
    if (res.ok) {
      return data;
    } else {
      throw Error(data);
    }
  }

export default FileUploadFetch;