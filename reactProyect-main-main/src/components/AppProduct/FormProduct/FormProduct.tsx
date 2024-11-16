import {Form} from "react-bootstrap";
import {useForm} from "../../../hooks/useForm.ts";
import {FC} from "react";

interface IPropsFormProduct {
    handleAddProduct: Function;
}

export const FormProduct: FC<IPropsFormProduct> =( {handleAddProduct}) =>{

    const {handleChange, values, resetForm} = useForm( {
        name:'' ,  image:'',  price: 0
    })

    const handleSubmit = () =>{
        handleAddProduct(values);
        resetForm();
    }

    return (
         <Form className='p-4 border rounded m-3'>
            <Form.Group controlId='formName'>
                <Form.Label>Nombre</Form.Label>
                <Form.Control type='text' name= 'name' placeholder='ingrese nombre producto' value={values.name} onChange={handleChange}/>
            </Form.Group>

             <Form.Group controlId='formImage'>
                 <Form.Label>Imagen</Form.Label>
                 <Form.Control type='text' name= 'image' placeholder='ingrese imagen del producto' value={values.image} onChange={handleChange}/>
             </Form.Group>

             <Form.Group controlId='formPrice'>
                 <Form.Label>Precio</Form.Label>
                 <Form.Control type='number' name= 'price' placeholder='ingrese el precio del producto' value={values.price} onChange={handleChange}/>
             </Form.Group>
             <div className="d-flex justify-content-center mt-4">
                 <button onClick={handleSubmit}  >Send form</button>
             </div>
         </Form>
     )
}