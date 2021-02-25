import React from 'react'
import {
  Button,
  Image,
  StyleSheet,
  Text,
  TextInput,
  View
} from 'react-native'

export const Login = ({ navigation }) => {
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
      />
      <TextInput
        placeholder="Password"
        style={styles.textInput}
      />
      <Button
        color="#666666"
        title="Login"
        onPress={() =>
          navigation.navigate('Main')
        }
        style={styles.button}
      />
      </View>
      </View>
  )
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
