package pom.pages;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.BasePage;
import pom.pages.packagesObjets.*;

import java.util.ArrayList;
import java.util.List;

public class PaquetesPage extends BasePage {
        @FindBy(id = "input-availables_search")
        private WebElement inputSearchCandidates;

        @FindBy(id = "svg-search_icon")
        private WebElement svgCandidatesSearch;

        @FindBy(id = "form-tickler")
        private WebElement formTickler;

        @FindBy(id = "table-currents")
        private WebElement tableCurrents;

        @FindBy(id = "table-features")
        private WebElement tableServices;

        @FindBy(id = "table-conducts")
        private WebElement tableBehavior;

        @FindBy(id = "table-conducts_history")
        private WebElement tableBehaviorHistory;

        @FindBy(id = "button-show_history")
        private WebElement btnShowHistory;

        @FindBy(id = "input-history_search")
        private WebElement inputHistorySearch;

        @FindBy(id = "svg-search_icon")
        private WebElement btnHistorySearch;

        @FindBy(id = "table-history")
        private WebElement tableHistory;

        @FindBy(id = "svg-history_close_icon")
        private WebElement svgCloseHistory;

        @FindBy(id = "table-availables")
        private WebElement tableAvailables;

        @FindBy(id = "svg-availables_close_icon")
        private WebElement svgAvailablesClose;

        @FindBy(id = "button-cancel")
        private WebElement btnCancel;

        @FindBy(id = "button-save")
        private WebElement btnSave;

        @FindBy(id = "div-servicios_title")
        private WebElement tabServices;

        @FindBy(id = "div-comportamientos_title")
        private WebElement tabBehivor;

        @FindBy(id = "div-tickler_title")
        private WebElement tabTickler;


        public PaquetesPage(WebDriver driver) {
                super(driver);
        }

        public void SearchInput(WebElement element, String packageNeeded, WebElement scv) throws Exception {
                waitForEnable(element);
                setText(element, packageNeeded);
                click(scv);

        }
        public void SelectPackage(WebElement element, String packageNeeded, WebElement scv) throws Exception{
                SearchInput(element, packageNeeded, scv);
                waitForEnable(tableAvailables);

                click(btnSave);
                waitForEnable(inputSearchCandidates);
        }
        public List<List<WebElement>> GetTable(@NotNull WebElement table)throws Exception{
                List<List<WebElement>> tableOut= new ArrayList<List<WebElement>>();
                List<WebElement> rowOut= new ArrayList<WebElement>();

                List<WebElement> rows = table.findElements(By.tagName("tr"));
                for (WebElement row : rows) {
                        List<WebElement> columns = row.findElements(By.tagName("td"));
                        rowOut.addAll(columns);
                }
                tableOut.add(rowOut);
                return tableOut;
        }

        public List<Vigentes> GetCurrents()throws Exception{
                Vigentes Currents = new Vigentes();
                List<Vigentes> CurrentTable = new ArrayList<Vigentes>();
                List<List<WebElement>> tablaWebElement = new ArrayList<List<WebElement>>();
                tablaWebElement = (GetTable(tableCurrents));
                for (List<WebElement> row : tablaWebElement) {
                        Currents.idPaquete = row.get(0).getText();
                        Currents.descripcion = row.get(1).getText();
                        Currents.precio = row.get(2).getText();
                        Currents.activacion = row.get(3).getText();
                        Currents.modificacion = row.get(4).getText();
                        Currents.cancelacion = row.get(5).getText();
                        Currents.familia = row.get(6).getText();
                        Currents.desactivar = row.get(7); // web element (switch)
                        CurrentTable.add(Currents);

                }
                return CurrentTable;
        }
        public List<Servicios> GetServices()throws Exception{
                Servicios Services = new Servicios();
                List<Servicios> ServicesTable = new ArrayList<Servicios>();
                List<List<WebElement>> tablaWebElement = new ArrayList<List<WebElement>>();
                tablaWebElement = (GetTable(tableServices));
                for (List<WebElement> row : tablaWebElement) {
                        Services.idFeatures = row.get(0).getText();
                        Services.descripcion = row.get(1).getText();
                        Services.tipo = row.get(2).getText();
                        Services.desactivar = row.get(3);// web element (switch)
                        ServicesTable.add(Services);

                }
                return ServicesTable;
        }
        public List<Comportamientos> GetBehavior()throws Exception{
                Comportamientos Behavior = new Comportamientos();
                List<Comportamientos> BehaviorTable = new ArrayList<Comportamientos>();
                List<List<WebElement>> tablaWebElement = new ArrayList<List<WebElement>>();
                tablaWebElement = (GetTable(tableBehavior));
                for (List<WebElement> row : tablaWebElement) {
                        Behavior.descripcion = row.get(0).getText();// web element (switch)
                        Behavior.activar = row.get(1);
                        BehaviorTable.add(Behavior);
                }
                return BehaviorTable;
        }
        public List<ComportamientosHistorico> GetBehaviorHistoric()throws Exception{
                ComportamientosHistorico BehaviorHistoric = new ComportamientosHistorico();
                List<ComportamientosHistorico> BehaviorHistoricTable = new ArrayList<ComportamientosHistorico>();
                List<List<WebElement>> tablaWebElement = new ArrayList<List<WebElement>>();
                tablaWebElement = (GetTable(tableBehaviorHistory));
                for (List<WebElement> row : tablaWebElement) {
                        BehaviorHistoric.descripcion = row.get(1).getText();
                        BehaviorHistoric.usr = row.get(2).getText();
                        BehaviorHistoric.activacion = row.get(3).getText();
                        BehaviorHistoric.cancelacion = row.get(5).getText();
                        BehaviorHistoricTable.add(BehaviorHistoric);
                }
                return BehaviorHistoricTable;
        }
        public List<Tickler> GetTickler()throws Exception{
                Tickler Tickler = new Tickler();
                List<Tickler> TicklerTable = new ArrayList<Tickler>();
                List<List<WebElement>> tablaWebElement = new ArrayList<List<WebElement>>();
                tablaWebElement = (GetTable(formTickler));
                for (List<WebElement> row : tablaWebElement) {
                        Tickler.numeroDeTickler = row.get(0).getText();
                        Tickler.fechaHora = row.get(1).getText();
                        Tickler.usr = row.get(2).getText();
                        Tickler.usr2 = row.get(3).getText();
                        Tickler.grupoDeUsuario = row.get(4).getText();
                        Tickler.grupoDeUsuario2 = row.get(5).getText();
                        Tickler.accion = row.get(6).getText();
                        Tickler.accion2 = row.get(7).getText();
                        Tickler.razon = row.get(8).getText();
                        Tickler.razon2 = row.get(9).getText();
                        Tickler.estado = row.get(10).getText();
                        Tickler.estado2 = row.get(11).getText();
                        Tickler.descripcion = row.get(12).getText();
                        TicklerTable.add(Tickler);
                }
                return TicklerTable;
        }
        public List<Historico> GetHistoric()throws Exception{
                Historico Historic = new Historico();
                List<Historico> HistoricTable = new ArrayList<Historico>();
                List<List<WebElement>> tablaWebElement = new ArrayList<List<WebElement>>();
                tablaWebElement = (GetTable(tableHistory));
                for (List<WebElement> row : tablaWebElement) {
                        Historic.idPaquete = row.get(0).getText();
                        Historic.descripcion = row.get(1).getText();
                        Historic.precio = row.get(2).getText();
                        Historic.activacion = row.get(3).getText();
                        Historic.modificacion = row.get(4).getText();
                        Historic.cancelacion = row.get(5).getText();
                        Historic.familia = row.get(6).getText();
                        Historic.usrAlta = row.get(7).getText();
                        Historic.usrBaja = row.get(8).getText();
                        HistoricTable.add(Historic);
                }
                return HistoricTable;
        }
        public void goToPaquetesPage() {
                getDriver().get(environment().urlPaquetes());

        }



 //      SearchInput (input, str) OK
 //      SelectAvailables (str) => bool
 //      GetTable (table) => list ok
        // Get Objet ( current - historic - behavior - historic behaivor - tickler - services)

//      SearchInTable  (string, table) => row
 //      Activate/desactivateSwitch (row) =>bool
 //      VerifyStateSwitch (row) =>bool
 //      SwitchToTab (string)
 //      GetFormatedForm (form) => dictionary
 //      GetMessages => String
 //      ValidateMessages (list[string] )=> Bool

/*        public void setEstadoActivo() throws Exception {
                waitForEnable(btnActivo);
                click(btnActivo);
        }

        public void setEstadoSuspendido() throws Exception {
                waitForEnable(btnSuspendido);
                click(btnSuspendido);
        }

        public String getCurrentState() throws Exception {
                return getValue(currentState);
        }

        public String getCurrentReason() throws Exception {
                return getValue(currentReason);
        }

        public void setRazon(String razon) throws Exception {
                waitForEnable(selectRazon);
                Thread.sleep(500);
                click(selectRazon);
                waitPresenceOfElement(By.xpath("//*[contains(text(),'" + razon + "')]"));
                click(getDriver().findElement(By.xpath("//*[contains(text(),'" + razon + "')]")));
                Thread.sleep(500);
        }



        public boolean cambioDeEstadoPageIsDisplayed() throws Exception {
                int time = 0;
                while (!currentState.isDisplayed() && time < 20) {
                        Thread.sleep(250);
                        time += 0.25;
                }
                return currentState.isDisplayed();
        }

        public void clickBtnGrabarCambio() throws Exception {
                click(btnGrabarCambio);
        }

        public boolean isNewStateEnabled(String newState) throws Exception {
                waitForEnable(selectRazon);
                switch (newState.toUpperCase()) {
                        case "ACTIVA":
                                return btnActivo.isEnabled();
                        case "SUSPENDIDA":
                                return btnSuspendido.isEnabled();
                        case "CANCELADA":
                                return btnCancelado.isEnabled();
                        default:
                                System.out.println("Opciones validas ACTIVA, CANCELADA o SUSPENDIDA. Opcion ingresada: " + newState);
                                return false;

                }
        }

        public boolean isCurrentStateContainingNewString(String newState) throws Exception {
                waitForValue(currentState, newState);
                if (getValue(currentState).toUpperCase().contains(newState.toUpperCase())) {
                        return true;
                } else {
                        return false;
                }
        }

        public boolean isCurrentReasonContainingNewString(String newReason) throws Exception {
                waitForValue(currentReason, newReason);
                if (getValue(currentReason).toUpperCase().contains(newReason.toUpperCase())) {
                        return true;
                } else {
                        return false;
                }
        }

        public boolean isMsgDisplayed(String msg) throws Exception {
                waitPresenceOfElement(By.xpath("//*[contains(text(),'" + msg + "')]"));
                if (getDriver().findElement(By.xpath("//*[contains(text(),'" + msg + "')]")).isDisplayed()) {
                        return true;
                } else {
                        return false;
                }

        }*/
}

