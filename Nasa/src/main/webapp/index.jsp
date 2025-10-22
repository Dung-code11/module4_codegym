<%@ page import="dao.FeedbackDAO,model.Feedback,java.util.List" %>
<html>
<head>
    <title>NASA APOD</title>
</head>
<body>
    <h2>Bức ảnh của ngày (NASA)</h2>
    <img id="img-of-the-day" width="600"/>
    <script>
      let query = 'https://api.nasa.gov/planetary/apod?api_key=YOUR_API_KEY';
      let request = new XMLHttpRequest();
      request.open('GET', query);
      request.onload = function() {
        if (request.status === 200) {
          let response = JSON.parse(request.responseText);
          document.getElementById('img-of-the-day').setAttribute('src', response.url);
        }
      };
      request.send();
    </script>

    <h3>Thêm nhận xét</h3>
    <form method="post" action="feedback">
        <input type="hidden" name="action" value="add"/>
        Tên: <input type="text" name="name"/><br/>
        Đánh giá (1-5): <input type="number" name="rating" min="1" max="5"/><br/>
        Nhận xét: <textarea name="comment"></textarea><br/>
        <button type="submit">Gửi</button>
    </form>

    <h3>Nhận xét hôm nay</h3>
    <%
        FeedbackDAO dao = new FeedbackDAO();
        List<Feedback> list = dao.getTodayFeedbacks();
        for (Feedback fb : list) {
    %>
        <div style="border:1px solid #ccc; margin:5px; padding:5px;">
            <b><%= fb.getName() %></b> - Rating: <%= fb.getRating() %>/5 <br/>
            <%= fb.getComment() %> <br/>
            Likes: <%= fb.getLikes() %>
            <form method="post" action="feedback" style="display:inline;">
                <input type="hidden" name="action" value="like"/>
                <input type="hidden" name="id" value="<%= fb.getId() %>"/>
                <button type="submit">Like</button>
            </form>
        </div>
    <%
        }
    %>
</body>
</html>
