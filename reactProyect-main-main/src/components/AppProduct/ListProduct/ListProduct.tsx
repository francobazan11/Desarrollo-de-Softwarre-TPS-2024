import {FC} from "react";
import {Button, Card} from "react-bootstrap";

interface ItemProduct{
    price: number;
    image: string;
    name: string;
}

interface IPropsListProduct{
    arrayItems: ItemProduct[];
}

export const ListProducts :FC<IPropsListProduct> = ({arrayItems}) => {

    return (
        <div className="p-1 m-2 border rounded d-grid gap-2"
             style={{gridTemplateColumns: "repeat(2,1fr)", justifyItems:"center", alignItems:"center"}}>
            {
                arrayItems.map((el,i) => (
                    <Card key={i} style={{ width: '18rem' }}>
                        <Card.Img variant="top" src={el.image} />
                        <Card.Body>
                            <Card.Title>{el.name}</Card.Title>
                            <Card.Text>
                                ${el.price}
                            </Card.Text>
                        </Card.Body>
                    </Card>
                ))
            }
        </div>
    )
}