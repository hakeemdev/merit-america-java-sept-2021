import React from "react";
class ContactUs extends React.Component{
    constructor(props) {
        super(props);
        this.state = {value: ''};
    
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
      }
    
      handleChange(event) {
        this.setState({value: event.target.value});
      }
    
      handleSubmit(event) {
        alert(this.state.value + ', your form was submitted.');
        event.preventDefault();
      }
    
      render() {
        return (<main>

        
          <form onSubmit={this.handleSubmit}>
            <label for = "name">
            Name:
            <input type="text" value={this.state.value} onChange={this.handleChange} />
            </label>
            <br></br>
            <label for="Popsicle Monthly">
                How did you hear about us?
            <select name="Popsicle Monthly" id="Popsicle Monthly">
            <option value="Popsicle Monthly">Popsicle Monthly</option>
            <option value="Popsicle Monthly">Local News</option> 
            <option value="Popsicle Monthly">Colleague</option>
            <option value="Popsicle Monthly">Radio Station</option>
            </select>
            </label>
            <label for="favorite">
            What color is your favorite popsicle?
            <input type="color" name="favorite" id="favorite" value="#87ceeb"/>
            </label>
            <label for="comments">
                Please let us know any comments you have:
            <textarea name="comments" id="comments" cols="10" rows="15"></textarea>
            </label>

            <input type="submit" value="Submit" />
          </form>
          </main>
        );
    }
}
export default ContactUs;