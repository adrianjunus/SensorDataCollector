# This script will run another script with elevated privileges
param(
    [string]$scriptPath
)

Start-Process powershell -ArgumentList "-ExecutionPolicy Bypass -File `"$scriptPath`"" -Verb RunAs
