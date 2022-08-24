from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

from zipfile import ZipFile

import os
import time
from datetime import datetime, timedelta


requestUrl = "https://www.juso.go.kr/addrlink/attrbDBDwld/attrbDBDwldList.do"
chromeDownloadUrl = "chrome://downloads/"
#chromeDriverPath = "D:/SD Task/chromedriver"
downloadWaitingTime = 10

zipFileRootPath = 'D:/SD Task/variable/zip'
unzipFileRootPath = 'D:/SD Task/variable/unzip'

bldTagId = "DCChk"
addrTagId = "DCMChk"


def initChromeBrowser():
    chromeOptions = webdriver.ChromeOptions()
    chromeOptions.add_experimental_option('prefs', {'download.default_directory':r'D:\SD Task\variable\zip'})
    driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=chromeOptions)
    driver.get(requestUrl)
    
    #건물, 주소 컨텐츠 Tag 확인 
    contentTags = findContentTagsID(driver)
    #컨텐츠 다운로드
    downloadData(contentTags, driver)

    driver.get(chromeDownloadUrl)
    if (checkIsCompletedDownload(downloadWaitingTime, driver)):
        print("파일 다운로드 성공")
    else:
        print("파일 다운로드 실패")

def findContentTagsID(driver):
    yesterday = getFormattedDateOfYesterday()

    # bldDayVariableDataTag = driver.find_element(By.CSS_SELECTOR, (f'#{yesterday}{bldTagId}'))
    # addrDayVariableDataTag = driver.find_element(By.CSS_SELECTOR, (f'#{yesterday}{addrTagId}'))

    contentTags = []
    contentTags.append(f'#{yesterday}{bldTagId}')
    contentTags.append(f'#{yesterday}{addrTagId}')

    return contentTags
    

def downloadData(contentTagsID, driver):
    for i, contentTagID in enumerate(contentTagsID):
        print(contentTagID)
        contentTag = driver.find_element(By.CSS_SELECTOR, contentTagID)
        contentTag.click()


def checkIsCompletedDownload(waitTime, driver):
    endTime = time.time() + waitTime
    while True:
        try:
            # progressTag = "return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress')"
            # WebDriverWait(driver, 10).until(EC.text_to_be_present_in_element(driver.execute_script(
            #     progressTag)))
            # get downloaded percentage
            downloadPercentage = driver.execute_script(
                "return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value")
            # check if downloadPercentage is 100 (otherwise the script will keep waiting)
            if downloadPercentage == 100:
                # return the file name once the download is completed
                # 완료된 파일 이력 삭제
                # downloadsItem = driver.execute_script(
                #     "return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot"
                # )
                # downloadsItem.find_element(By.CSS_SELECTOR, 'cr-icon-button').click()
                return True
        except:
            return False
        if time.time() > endTime:
            return False

def unZipDataFiles():
    zipFilePath = zipFileRootPath + "/" + getFormattedDateOfYesterday()
    unzipFilePath = unzipFileRootPath + "/" + getFormattedDateOfYesterday()
    makeDir(zipFilePath)
    makeDir(unzipFilePath)
    moveFiles(zipFilePath)

    for file in os.listdir(zipFilePath):
        with ZipFile(f'{zipFilePath}/{file}') as zipFile:
            zipFile.extractall(unzipFilePath)
    print("파일 압축해제 완료")

def moveFiles(dest):
    files = os.listdir(zipFileRootPath)
    print(zipFileRootPath)
    for file in files:
        if(os.path.isfile(zipFileRootPath + "/" + file)):
            print(file)
            os.replace(zipFileRootPath + "/" + file, dest + "/" + file)

def makeDir(dirPath):
    try:
        os.makedirs(dirPath)
    except OSError:
        if not os.path.isdir(dirPath):
            raise

def getFormattedDateOfYesterday():
    formattedDateOfYesterday = (datetime.today() - timedelta(1)).strftime("d%Y%m%d")
    return formattedDateOfYesterday


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    initChromeBrowser()
    unZipDataFiles()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
