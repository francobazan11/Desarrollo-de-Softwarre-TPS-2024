import MyFirstComponent from "./components/FirstOne/FirstComponent.tsx";
import {ComponentCounter} from "./components/ComponentCounter/ComponentCounter.tsx";
import {useState} from "react";
import {ComponentUseEffect} from "./components/ComponentUseEffect/ComponentUseEffect.tsx";
import FormComponent from "./components/Formcomponent/FormComponent.tsx";
import {AppProduct} from "./components/AppProduct/AppProduct.tsx";

export const App = () => {

    const [enableCounter,setEnableCounter] = useState<boolean>(false);
    return (
        <div className="App" style={ {display: 'flex', flexDirection: 'column' }}>
            <MyFirstComponent  text={"Texto loco" } backgroundColor={"blue"} fontSize={4} />
            {
                enableCounter &&  <ComponentCounter/>
            }
            <button onClick={ ()=> {setEnableCounter(!enableCounter) }}>Mostrar contador</button>
            <h3>Componente use effect</h3>
            <ComponentUseEffect/>
            <h4>Form</h4>
            <FormComponent/>
            <AppProduct/>
        </div>

    )
}

