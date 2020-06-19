elem = document.getElementById('click_button');
elem.addEventListener('click', async(evt) => {
  evt.preventDefault();
  const email = document.querySelector('.email').value;
  const username = document.querySelector('.username').value;
  const password = document.querySelector('.password').value;
  const data = {
    email,
    username,
    password
  }
  const url = "http://127.0.0.1:4567/api/login/auth";
  try {
  const response = await fetch(url, {
    method: 'POST',
    body: JSON.stringify(data),
    headers: {
      'Content-Type': 'application/json'
    }
  });
  const json = await response.json();
  console.log('Успех:', JSON.stringify(json));
  document.cookie = "authorization = " + json.message + "; path = http://127.0.0.1:4567/";
  } catch (error) {
    console.error('Ошибка:', error);
  }
  document.location.href = "http://127.0.0.1:4567/feed";
})
