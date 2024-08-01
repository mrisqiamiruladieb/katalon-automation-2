import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://kasirdemo.belajarqa.com/')

'Assert sudah berada di web kasirAja'
WebUI.waitForElementVisible(findTestObject('kasirAja/Page_Login/h2_hai, kasirAja'), 0)

'Klik link register'
WebUI.click(findTestObject('kasirAja/Page_Login/register_link'))

'Assert sudah berada di register page'
WebUI.waitForElementVisible(findTestObject('kasirAja/Page_Register/button_register'), 0)

'Generate Random Value'
randInt = ((Math.random() * 10) as int)

'Input nama toko'
WebUI.setText(findTestObject('Object Repository/kasirAja/Page_Register/store_name_field'), 'toko mobil-mobilan ' + randInt)

'Input email'
WebUI.setText(findTestObject('kasirAja/Page_Login/email_field'), 'ini_email_invalid ' + randInt)

'Input password'
WebUI.setEncryptedText(findTestObject('kasirAja/Page_Login/password_field'), 'e8uvrdU4NP4/oGXwquQ//Q==')

'Klik tombol register'
WebUI.click(findTestObject('Object Repository/kasirAja/Page_Register/button_register'))

'Assert pesan error email invalid'
WebUI.waitForElementVisible(findTestObject('Object Repository/kasirAja/Page_Register/error_email_invalid'), 0)

WebUI.closeBrowser()

