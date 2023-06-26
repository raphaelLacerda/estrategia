const { Builder, By, Key, until } = require('selenium-webdriver');

module.exports = class HelloGoogle {

    async entrar_no_google() {
        let driver = await new Builder().forBrowser('chrome').build();
        try {
            //abrir google
            await driver.get('http://google.com');

            // Enter text "cheese" and perform keyboard action "Enter"
            await driver.findElement(By.name('q')).sendKeys('estrategia concursos', Key.ENTER);
            // await driver.findElement(By.id('home-search-field'))
            //     .sendKeys('choque de cultura', Key.ENTER);

            let firstResult = await driver.wait(until.elementLocated(By.css('.r>a')), 10000);

            console.log(firstResult);

            await firstResult.click();

            
        }
        finally {
            setTimeout(()=>{
                driver.quit();
            }, 5000);
        }
    }

}