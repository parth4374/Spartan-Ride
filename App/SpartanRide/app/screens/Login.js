import React from 'react'
import {
  Button,
  Image,
  StyleSheet,
  Text,
  TextInput,
  View
} from 'react-native'

export class Login extends React.Component {
  constructor () {
    super()
    this.state = {
      username: '', password: ''
    }
  }

  render () {
    const { navigation } = this.props
    return (
      <View style={styles.container}>
        <Image
        source={require('./appicon.png')}
        style={styles.image}
        />
        <View style={styles.form}>
          <Text style={styles.textInputHeader}>UNCG Login:</Text>
          <TextInput
            placeholder="Email"
            style={styles.textInput}
            value={this.state.name}
            onChangeText={(name) => this.setState({ name })}
          />
          <TextInput
            placeholder="Password"
            secureTextEntry={true}
            style={styles.textInput}
            value={this.state.password}
            onChangeText={(password) => this.setState({ password })}
          />
          <Button
            color="#666666"
            title="Login"
            onPress={() =>
              navigation.navigate('Main', { name: this.state.name })
            }
            style={styles.button}
          />
        </View>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#3366ff',
    flex: 1
  },
  image: {
    alignSelf: 'center',
    aspectRatio: 0.5,
    flex: 1,
    resizeMode: 'contain'
  },
  form: {
    flex: 1
  },
  textInputHeader: {
  },
  textInput: {
    color: 'white'
  },
  button: {
    alignSelf: 'center'
  }
})
