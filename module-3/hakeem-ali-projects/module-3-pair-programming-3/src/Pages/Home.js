import React from "react";
class Home extends React.Component{
    render(){
        return(
    <div>
      <main>
          <img src="./images/popsicle-rainbow.jpg" alt=""/>
            <div>
              <h2>Did you Know?</h2>
              <ul>
                  <li>The earliest known popsicles date as far back as 1872. Back then, a popsicle was called a Hokey-Pokey.</li>
                  <li>Popsicles are also known as freezer pops, ice lollies, and ice pops.</li>
                  <li>The world's largest popsicle was made in 1997 and was 21 feet tall.</li>
                  <li>Popsicles have become so popular that a popular arts and craft item is called a popsicle stick.</li>
              </ul>
            </div>
      </main>

      <section id="popsicle-race">
        <img id="blue-pop" src="images\blue-pop.png" alt="Blue popsicle"/>
          <div>
            <h2>
              Popsicle Race
            </h2>
            <p>
              Don't forget to sign up for the race! Each attendee will recieve their own box of popsicles when they reach the
              end.
            </p>
          </div>
      </section>
      
      <section id="get-refreshed">
        <div>
          <h2>Get refreshed this Summer!</h2>
          <p>
          Mark this very special occasion of the launch of Tech Elevator Popsicels by buying a gift from our stunning
          array of items, shipped directly from Cleavland.
          </p>
          <a href="#">STORE</a>
        </div>
      </section>
    </div>
        )
    }
}
export default Home;