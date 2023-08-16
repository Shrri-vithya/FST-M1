# Set up the Firefox Driver with WebDriverManger
from selenium.webdriver import ActionChains, Keys
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:

    # Navigate to the URL
    driver.get("https://v1.training-support.net/selenium/input-events")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Declare actions variable
    actions = ActionChains(driver)

    # Then Perform the action in separate lines using the actions object
    actions.send_keys("S")
    actions.key_down(Keys.CONTROL)
    actions.send_keys("a")
    actions.send_keys("c")
    actions.key_up(Keys.CONTROL)
    actions.perform()

