
async function FileUploadFetch(host, path, file) {
    const url = `http://${host}/${path}`;
    const options = {
      method: 'POST',
      headers: {
        'Content-Type': 'multipart/form-data',
      },
      body: file,
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