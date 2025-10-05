🧾 Project Description: MIS – Daily Task & Attendance Reporting System
📌 Overview

The MIS Web Application (Management Information System) is a role-based platform designed to streamline and automate the daily task and attendance reporting workflow within an organization. The system enables employees to submit their daily work summaries and attendance records, which are then reviewed and approved by supervisors. Admins have full visibility into all reports for auditing, performance tracking, and organizational analytics.

This tool improves communication, accountability, and productivity tracking, ensuring accurate daily reporting and efficient managerial oversight.

🎯 Objectives

Enable employees to log daily tasks and attendance records.

Provide supervisors with tools to review, approve, or reject employee submissions.

Offer administrators a centralized dashboard for monitoring, reporting, and data analysis.

Ensure secure, role-based access and workflows.

Facilitate transparency and reduce manual reporting overhead.

👥 User Roles & Permissions
Role	Description
Employee	- Submits daily task reports and attendance
- Views submission status
Supervisor	- Reviews employee submissions
- Approves or rejects reports
- Provides feedback
Admin	- Full access to all reports and user data
- Manages users
- Views analytics
🔄 System Workflow

Login & Authentication

All users log in through a secure authentication system.

Role-based access is enforced via JWT and Spring Security.

Daily Report Submission (Employee)

Employee logs in and submits:

Attendance (Present, Remote, Absent, etc.)

Task list for the day (title, description, hours spent, status)

Report is submitted with Pending status.

Review & Approval (Supervisor)

Supervisor sees all pending reports for employees under their supervision.

Reviews content, leaves optional feedback.

Marks report as Approved or Rejected.

Monitoring & Analytics (Admin)

Admin has access to all reports from all users.

Can filter by date, employee, department, status.

Can export reports or view analytics (e.g., attendance trends, productivity).

🧱 Core Features
✅ Employee Portal

Daily report form with attendance and task entries.

View submission history and approval status.

Edit or re-submit rejected reports.

✅ Supervisor Portal

Dashboard with pending approvals.

View task details and attendance.

Approve or reject reports.

Provide feedback to employees.

✅ Admin Panel

Access to all reports across the organization.

Role management (create/edit users, assign roles).

Analytics dashboard (charts, filters, statistics).

Export reports to CSV/PDF.

✅ Notification System (Optional)

Email or in-app alerts when:

A report is submitted.

A report is approved/rejected.

🗃️ Database Schema (Simplified)
📋 users

id, name, email, password, role, supervisor_id

📋 daily_reports

id, user_id, date, status, attendance, feedback, submitted_at, approved_at

📋 tasks

id, report_id, title, description, status, hours_spent

⚙️ Technology Stack
Layer	Technology
Frontend	React, Vite, Material UI, Axios
Backend	Java 8, Spring Boot, Spring Security, JWT
Database	MySQL / PostgreSQL
Authentication	JWT-based role authentication
Deployment	(Optional) Vercel (frontend), Render/Heroku/AWS (backend)
📈 Future Enhancements (Ideas)

Role-based notifications

Automated reminders for report submission

Calendar view for attendance

PDF export of individual reports

Department-wise analytics and comparison

Mobile-friendly version or PWA

📌 Benefits

Reduces paperwork and manual reporting.

Increases transparency and accountability.

Simplifies report tracking for management.

Enhances employee performance evaluation.

📸 Sample Use Case

On October 5, Milad (an employee) logs in, marks himself Remote, and logs 4 tasks for the day. His supervisor, Sara, reviews the report, approves it, and leaves feedback. The admin later views the report as part of the monthly attendance audit.
