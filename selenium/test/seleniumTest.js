var assert = require('assert');
const { Builder, By, Key, until } = require('selenium-webdriver');

describe('Testes do Selenium Test', function () {
  this.timeout(50000);
  let driver;
  before(async function(){
     driver = await new Builder().forBrowser('chrome').build();
  });

  after(function(){
    setTimeout(() => {
      driver.quit();
    }, 10000);
  })


  describe('quando localizar o link na home', function () {
    
    it('deve ir para página de testes', async function () {

        //abrir google
        await driver.get('https://www.seleniumeasy.com/');

        let botao = await driver.findElement(By.css('.header-right a'));
        await botao.click();

        let menu = await driver.wait(until.elementLocated(By.css('.tree-branch>a')), 10000);

        let texto = await menu.getText();

        assert.equal(texto, 'All Examples');

        return;
    });
    
    it('deve submeter formulario', async function () {

        //abrir google
        await driver.get('https://www.seleniumeasy.com/test/ajax-form-submit-demo.html');

        let name = await driver.findElement(By.id('title'));
        let comment = await driver.findElement(By.id('description'));
        let botao = await driver.findElement(By.id('btn-submit'));
        let divResposta = await driver.findElement(By.id('submit-control'));

        await name.sendKeys('Raphael Lacerda');
        await comment.sendKeys('comentario com texto legal');
        await botao.click();

        await driver.wait(until.elementTextContains(divResposta, 'Form submited Successfully!'), 10000);

        return;
    });
  });
});