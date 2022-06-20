import React from 'react';

async function CustomFetch(host, path, body, headers = {}) {
  const url = `http://${host}/${path}`;
  const options = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      ...headers,
    },
    body: JSON.stringify(body),
  };
  const res = await fetch(url, options);
  const data = await res.json();
  if (res.ok) {
    return data;
  } else {
    throw Error(data);
  }
}

export default CustomFetch;
