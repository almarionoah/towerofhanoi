# How to run Tower of Hanoi locally

_Maintained by Sable Adeyemi (Engineering). Updated 2026-10-09T22:12:59.981Z._

This guide gets a working version of **Tower of Hanoi** running on macOS, Linux or Windows using **npm** or **http-server**.

## 1. Prerequisites
- **Node.js 18+** (includes npm). Check with `node -v` and `npm -v`.
  - macOS: `brew install node` or download from https://nodejs.org
  - Linux (Debian/Ubuntu): `sudo apt update && sudo apt install -y nodejs npm` (or use nvm)
  - Windows: install the LTS installer from https://nodejs.org, then open **PowerShell**
- **Git**: https://git-scm.com/downloads

## 2. Get the code
```bash
git clone https://github.com/almarionoah/towerofhanoi.git
cd towerofhanoi
```

## 3a. Option A — npm project (has a package.json)
```bash
npm install
npm run dev      # or: npm start
```
Open the URL printed in the terminal (usually http://localhost:5173, :3000 or :8080).
To build for production: `npm run build` then `npm run preview`.

## 3b. Option B — static site with http-server (plain HTML/CSS/JS)
```bash
npx http-server . -p 8080 -c-1
```
or install once globally: `npm install -g http-server` then `http-server . -p 8080`.
Open http://localhost:8080 in your browser.

## 4. OS-specific notes
| Step | macOS / Linux (Terminal) | Windows (PowerShell) |
| --- | --- | --- |
| Copy env file | `cp .env.example .env` | `Copy-Item .env.example .env` |
| Free a busy port | `lsof -i :8080` then `kill <PID>` | `netstat -ano \| findstr :8080` then `taskkill /PID <PID> /F` |
| Permission error on global install | prefix with `sudo` or use nvm | run PowerShell as Administrator |
| Script blocked | — | `Set-ExecutionPolicy -Scope CurrentUser RemoteSigned` |

## 5. Troubleshooting
- `command not found: npm` → reinstall Node.js and reopen the terminal.
- Dependency errors → delete `node_modules` and `package-lock.json`, then `npm install` again.
- Blank page → open the browser console (F12) and check for missing environment variables.

## 6. Work assets for this project
- `work-assets/engineering/refactor-auth-service.md` — refactor auth service
