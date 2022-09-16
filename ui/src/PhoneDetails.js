import {Component} from "react";


class PhoneDetails extends Component {
    state = {
        phone: []
    };

    async componentDidMount() {
        const response = await fetch('/phone');
        const body = await response.json();
        this.setState({phone: body});
    }

    render() {
        const {phone} = this.state;
        return (
            <div>
                <h2>Phones</h2>
                {phone.map(detail =>
                    <div key={detail.id}>
                        {detail.name} ({detail.sid})
                    </div>
                )}
            </div>
        );
    }
}

export default PhoneDetails;