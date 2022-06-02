import React, { useEffect, useState }from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button} from '@material-ui/core';

/*TO DO 
ONLY DISPLAY Cat Card on refresh 
The second button should be labeled "Get next card" and should generate a new Cat Card in the display.
Each Cat Card in the collection should be labeled "Edit" and should allow the user to edit the Caption and CatFact on the Cat Card.



*/
export default function BasicTextFields() {
    const paperStyle = {padding: '50px 20px', width: 600, margin: '20px auto'}
    const [imgUrl, setimgUrl] = useState('');
    const [caption, setCaption] = useState('');
    const [fact , setFact] = useState('');
    const [catcards, setCatCards] = useState([]);
    const [newCards, setNewCards] = useState([]);

    const handleClick=(e) =>{
        e.preventDefault()
        const fact = "";
        
        const catcard = {imgUrl, caption, fact}
        console.log("catcard");

        fetch("http://localhost:8080/api/cards",{
            method: 'POST',
            headers: { "Content-Type": "application/json"},
            body: JSON.stringify(catcard)
        }).then(() =>{
            console.log("new catcard added.")
            getCatCards();
        })
    }
    
    function deleteCard(catCardId) {
        fetch("http://localhost:8080/api/cards" + "/" + catCardId, {
            method: 'DELETE',
        })
            .then((response) => {
                return response.text();
            })
            .then((data) => {
                console.log(data);
                console.log('Cat Card deleted!');
                getCatCards();
            })
    }

    function getCatCards(){
        fetch("http://localhost:8080/api/cards")
        .then(res => res.json())
        .then((result) => {
            setCatCards(result);
            }
        )
    }
    useEffect(() =>{
        getCatCards();
    },[])

      useEffect(() =>{
        fetch("http://localhost:8080/api/cards/random")
        .then(res => res.json())
        .then((result) => {
            setNewCards(result);
            console.log(newCards)
            }
        )
    },[])

  return (
   <Container>
       <Paper elevation= {10} style = {paperStyle}>
           {Object.values(newCards).map(newcard=>(
               <div key = {newcard}>
                    <img src={newcard} ></img><br/><br/>
               </div>
           ))}
           <form>  
      <TextField id="outlined-basic" label="Caption me!" variant="outlined" fullWidth value={caption} onChange={(e) => setCaption(e.target.value)} />
      <br/>
      <br/>
      <Button variant="contained" color ="secondary" onClick ={handleClick}>Add to collection</Button>
            </form>
            <br/>
        <Button variant="contained" color ="secondary" >Get next card</Button>
        </Paper>

        <h1> Your Collection</h1>

        <Paper elevation= {10} style = {paperStyle}>
            {catcards.map(catcard =>(
                <Paper elevation= {6} style = {{margin:'10px', padding: "15px", textAlign: "center"}} key ={catcard.id}>
                    ID: {catcard.catCardId} <br/><br/>
                    <img src={catcard.imgUrl}></img><br/><br/>
                    Fact: {catcard.fact}<br/><br/>
                    Caption: {catcard.caption}<br/><br/>
                    <Button variant="contained" color ="secondary" onClick ={()=> deleteCard(catcard.catCardId)} >Delete Card</Button>
                </Paper>
            ))}
           
        </Paper>
         
    </Container>
  );
}
