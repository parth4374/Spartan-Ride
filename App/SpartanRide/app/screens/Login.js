import React from 'react'
import {
  Button,
  Image,
  StyleSheet,
  Text,
  TextInput,
  TouchableOpacity,
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
          <View style={styles.inputContainer}>
            <TextInput
              placeholder="Email"
              placeholderTextColor="#fff"
              style={styles.textInput}
              value={this.state.name}
              underlineColorAndroid="#666666"
              onChangeText={(name) => this.setState({ name })}
            />
            <Image
              source={require('./arrowicon.png')}
            />
          </View>
          <View style={styles.inputContainer}>
            <TextInput
              placeholder="Password"
              placeholderTextColor="#fff"
              secureTextEntry={true}
              style={styles.textInput}
              value={this.state.password}
              underlineColorAndroid="#666666"
              onChangeText={(password) => this.setState({ password })}
            />
            <Image
              source={require('./arrowicon.png')}
            />
          </View>
          <View style={styles.button}>
            <Button
              color="#666666"
              title="Login"
              onPress={() =>
                navigation.navigate('Main', { name: this.state.name })
              }
            />
          </View>
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
    marginTop: -50,
    marginBottom: -30,
    resizeMode: 'contain'
  },
  inputContainer: {
    alignItems: 'center',
    flexDirection: 'row'
    // flex: 1
  },
  form: {
    flex: 1,
    paddingLeft: 20
  },
  textInputHeader: {
  },
  textInput: {
    color: 'white',
    flex: 1,
    textAlignVertical: 'top'
  },
  button: {
    alignSelf: 'center',
    paddingTop: 10,
    width: '80%'
  }
})
