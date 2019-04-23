@echo off

:: BatchGotAdmin
:-------------------------------------
REM --> Check for permissions
>nul 2>&1 "%SYSTEMROOT%\system32\cacls.exe" "%SYSTEMROOT%\system32\config\system"
REM --> If error flag set, we do not have admin.
if '%errorlevel%' NEQ '0' (
echo Requesting administrative privileges...
goto UACPrompt
) else ( goto gotAdmin )
:UACPrompt
echo Set UAC = CreateObject^("Shell.Application"^) > "%temp%\getadmin.vbs"
echo UAC.ShellExecute "%~s0", "", "", "runas", 1 >> "%temp%\getadmin.vbs"
"%temp%\getadmin.vbs"
exit /B
:gotAdmin
if exist "%temp%\getadmin.vbs" ( del "%temp%\getadmin.vbs" )
pushd "%CD%"
CD /D "%~dp0"
:--------------------------------------

call mvn -Dmaven.test.skip=true -U clean package

:: call docker build -t hub.c.163.com/pdpdwy/springcloudsell/order .
call docker build -t registry.cn-shenzhen.aliyuncs.com/jinhuazhiguang/springcloudsell-order:0.0.1 .

:: call docker push hub.c.163.com/pdpdwy/springcloudsell/order
call docker push registry.cn-shenzhen.aliyuncs.com/jinhuazhiguang/springcloudsell-order:0.0.1

pause