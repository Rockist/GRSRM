
async function FileUploadFetch(host, path, map) {
    const url = `http://${host}/${path}`;
    const form = new FormData();

    for (const [key, value] of map) {
      form.append(key, value);
    }
    
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