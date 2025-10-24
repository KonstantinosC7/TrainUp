<p align="center">
  <img src="/assets/TrainUp.jpg" alt="TrainUp — Internship & Training Placement" width="360">
  <br>
  <sub><em>Web app that connects students, companies, and universities for internships & training programs.</em></sub>
</p>

<h1 align="center">TrainUp (Spring Boot)</h1>

<p align="center">
  <a href="#overview">Overview</a> •
  <a href="#features">Features</a> •
  <a href="#architecture--tech">Architecture & Tech</a> •
  <a href="#screenshots">Screenshots</a> •
  <a href="#quickstart-dev">Quickstart</a>
</p>

---

## Overview

**TrainUp** is a Spring Boot web application that streamlines the process of discovering, applying to, and managing **internships / traineeships**.  
It bridges **Students**, **Companies**, and **University Staff** with clean role-based flows:
- Companies publish positions with requirements and capacity.
- Students browse/filter and apply; track status and offers.
- Staff/Admins moderate content, oversee matching, and manage platform settings.

---

## Features

### 👩‍🎓 Student
- Register/Login & profile (skills, interests, CV link).
- Browse **open positions** by company/category/skills.
- **Apply** with one click; see **application status** & history.
- Save favorites / continue later.
- Notifications on **status change** (accepted/rejected/offer).

### 🏢 Company
- Secure login & company profile (description, website, contact).
- **CRUD** on **Positions** (title, description, location, duration, capacity, skills).
- Review incoming **applications** per position.
- Change status: _Under Review → Interview → Offer/Reject_.
- Export basic reports (e.g., CSV list of candidates).

### 🏛️ Admin / Staff
- User management (activate/disable, reset roles).
- Content moderation (positions, categories, skills).
- Global settings (application windows, limits).
- Dashboard: basic **stats** (positions, applications, conversion).

### 🔐 Access & Roles
- Authentication/Authorization via **Spring Security**.
- Role-based UI: `ROLE_STUDENT`, `ROLE_COMPANY`, `ROLE_ADMIN` (επεκτάσιμο).
- Server-side validation & friendly error pages.

### 🧭 Usability
- **Search & filters** (category, skills, company, location).
- Pagination on heavy lists.
- Clear call-to-actions (Apply, Withdraw, Manage).
- Consistent navigation between lists and details.

---

## Architecture & Tech

<table>
  <tr>
    <td width="52%">
      <img src="assets/architecture.png" alt="Architecture Diagram" width="100%">
      <p align="center"><sub>High-level Architecture</sub></p>
    </td>
    <td width="48%" valign="top">

- **Spring Boot** (MVC): controllers, services, repositories.
- **Spring Security**: sessions & role-based access.
- **Thymeleaf** templates (server-side rendering).
- **JPA/Hibernate** over **MySQL** (or MariaDB).
- **Maven** for build & dependency management.
- Layered design: `controller → service → repository → entity`.
- DTOs & validation for clean forms.
- Conventional packaging under `src/main/java` and `templates/`.

    </td>
  </tr>
</table>

---

## Screenshots

<table>
  <tr>
    <td width="52%">
      <img src="assets/positions-list.png" alt="Positions list for Students" width="100%">
      <p align="center"><sub>Positions list — browse & apply.</sub></p>
    </td>
    <td width="48%" valign="top">

- Table with **Title / Company / Location / Skills / Action**.
- Quick filters & search bar.
- Each title links to a **details** page.
- **Apply** button per row (with confirmation).
- Footer links: **Back**, **My Applications**.

    </td>
  </tr>
</table>

<table>
  <tr>
    <td width="52%">
      <img src="assets/company-applications.png" alt="Company view of applications" width="100%">
      <p align="center"><sub>Company Dashboard — applications per position.</sub></p>
    </td>
    <td width="48%" valign="top">

- Overview: **Applicant / Skills / Status / Actions**.
- Status transitions: **Review → Interview → Offer/Reject**.
- **View Profile** & **Download CV** actions.
- Export CSV, pagination, and quick filters.

    </td>
  </tr>
</table>

---

## Quickstart (dev)

### Prereqs
- **JDK 17+**
- **Maven 3.8+**
- **MySQL 8.x** (ή MariaDB)

### 1) Database
Create DB & user (example names; adjust as needed):
```sql
CREATE DATABASE trainup CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'trainup_user'@'%' IDENTIFIED BY 'strong_password';
GRANT ALL PRIVILEGES ON trainup.* TO 'trainup_user'@'%';
FLUSH PRIVILEGES;
```


### License

This project is for academic purposes
