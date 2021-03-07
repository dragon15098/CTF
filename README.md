# Type
`de ctf - spring`
# Author
`quocnm3`
# Deploy
- `docker-compose up -d --build`
# Description
Lỗi Insecure deserialization.
Lỗi Access control vulnerabilities
## Chức năng
- Đăng kí, đăng nhập
- Sau khi đăng nhập có thể chỉnh tạo room, chat trong room, invite người khác vào room.
## Solution
- Đăng kí một tài khoản
- Brute force id room VIP. Dựa vào thông báo lỗi hiển thị tìm id room vip = 1
- Tự invite mình vào room VIP
- Chấp nhận lời invite
- Lấy source code từ message trong room vip
- Update lại environment property: spring.datasource.hikari.connection-test-query với payload sql rce.
- Gửi tin nhắn chứa tên class com.myjavablog.controller.Checker
- Chờ vài giây để Scheduled Task thực hiện và thực thi lệnh trong spring.datasource.hikari.connection-test-query
